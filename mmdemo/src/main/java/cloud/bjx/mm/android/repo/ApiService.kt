package cloud.bjx.mm.android.repo

import cloud.bjx.mm.android.bean.ResultBean
import cloud.bjx.mm.android.bean.TokenBean
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /** 获取 appKey、token */
    @GET("api/v1/appserver/token")
    suspend fun fetchToken(@Query("userID") uid: String): ResultBean<TokenBean>

}

object ServiceFactory {
    // private const val reqUrl = "http://srtcauth.bjx.cloud" // sit 地址

    // private const val reqUrl = "http://192.168.88.222:8888" // 内网地址
    private const val reqUrl = "https://rtcauth.bjx.cloud" // 外网地址
    val apiService: ApiService by lazy {
        RetrofitFactory.retrofit(reqUrl).create(ApiService::class.java)
    }

}