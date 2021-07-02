package io.github.bulbasaurs.pokegotchi.network

import okhttp3.Interceptor
import okhttp3.Response

class FourSquareClientInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url.newBuilder()
            .addQueryParameter("client_id", CLIENT_ID)
            .addQueryParameter("client_secret", CLIENT_SECRET)
            .addQueryParameter("v", API_VERSION)
            .addQueryParameter("ll", LAT_LONG)
            .build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)

    }

    companion object{
        private const val CLIENT_ID = "J3EKTIDCS3BMUKXH24VLI0ORAN3V141LJRH5SLMY3HFRKDF3"
        private const val CLIENT_SECRET = "Q0REGGRTGE3PSCIJHFCTN5OKPET0XHC1HDBTGBO0BY1SGEWP"
        private const val API_VERSION = "20180323"
        // Hardcoded to Wellington
        private const val LAT_LONG = "-41.2924,174.7787"
    }
}