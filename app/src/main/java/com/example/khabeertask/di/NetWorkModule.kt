import com.example.khabeertask.data.remote.EndPoints
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofitBuilder(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideEndPoints(client: OkHttpClient): EndPoints {
        return Retrofit.Builder()
            .client(client)
            .baseUrl("http://40.127.194.127:5656/Salamtak/")
//            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(EndPoints::class.java)
    }

}