package br.com.ysazaka.bitcoinquotation.data.rest

import android.app.Activity
import android.widget.Toast
import androidx.annotation.NonNull
import br.com.ysazaka.bitcoinquotation.util.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

/**
 * Created by Glauco Sazaka on 23/09/2020.
 */
internal abstract class RESTCallback<T> @JvmOverloads constructor(private val activity: Activity?) : CustomCallback<T>(), Callback<T> {

    protected var errorMessage: String? = ""
    val rest = retrofit.create(MainApi::class.java)

    override fun onResponse(call: Call<T>, response: Response<T>) {
        when (response.code()) {
            HttpURLConnection.HTTP_OK,
            HttpURLConnection.HTTP_CREATED,
            HttpURLConnection.HTTP_ACCEPTED,
            HttpURLConnection.HTTP_NOT_AUTHORITATIVE,
            HttpURLConnection.HTTP_RESET,
            HttpURLConnection.HTTP_PARTIAL -> onSuccess(
                response
            )
            422 -> onFailureValidation(response)
            HttpURLConnection.HTTP_NOT_FOUND,
            HttpURLConnection.HTTP_BAD_METHOD,
            HttpURLConnection.HTTP_INTERNAL_ERROR,
            HttpURLConnection.HTTP_NOT_IMPLEMENTED,
            HttpURLConnection.HTTP_BAD_GATEWAY,
            HttpURLConnection.HTTP_UNAVAILABLE,
            HttpURLConnection.HTTP_GATEWAY_TIMEOUT,
            HttpURLConnection.HTTP_VERSION,
            HttpURLConnection.HTTP_CONFLICT,
            HttpURLConnection.HTTP_UNAUTHORIZED,
            HttpURLConnection.HTTP_NO_CONTENT -> onFailure(
                response
            )
        }
    }

    override fun onFailure(@NonNull call: Call<T>?, @NonNull t: Throwable) {
        if (t is UnknownHostException) {
            Toast.makeText(activity, "Sem conexão à internet", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onFailure(response: Response<T>) {
        errorMessage = response.message()
        Toast.makeText(activity, response.message(), Toast.LENGTH_SHORT).show()
    }

    override fun onFailureValidation(response: Response<T>) {
        try {
            if (response.errorBody() != null) {
                val array = JSONArray(response.errorBody()!!.string())
                if (array.length() > 0) {
                    val `object` = array.getJSONObject(0)
                    errorMessage = `object`.getString("message")
                }

            }
        } catch (e: Exception) {
            errorMessage = e.message
            e.printStackTrace()

            try {
                val s = e.message
                val jObjError = JSONObject(s!!.substring(6))
                Toast.makeText(activity, jObjError.getString("message"), Toast.LENGTH_LONG)
                    .show()
            } catch (ex: Exception) {
                Toast.makeText(activity, ex.message, Toast.LENGTH_LONG).show()
            }

        }
    }

    companion object {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .create()
                )
            )
            .client(
                OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build()
            )
            .build()
    }
}