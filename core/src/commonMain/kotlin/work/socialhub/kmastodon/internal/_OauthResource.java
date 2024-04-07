package work.socialhub.kmastodon.internal;

import mastodon4j.api.OauthResource;
import mastodon4j.domain.Service;
import mastodon4j.entity.AccessToken;
import mastodon4j.entity.share.Response;
import net.socialhub.http.HttpMediaType;
import net.socialhub.http.HttpParameter;
import net.socialhub.http.HttpRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static mastodon4j.internal._InternalUtility.proceed;

/**
 * @author hecateball
 */
final class _OauthResource implements OauthResource {

    private final String uri;

    public _OauthResource(String uri) {
        this.uri = uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<AccessToken> issueAccessToken(String clientId, String clientSecret, String emailAddress, String password, String scopes) {
        return proceed(AccessToken.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/oauth/token")
                    .param("client_id", clientId)
                    .param("client_secret", clientSecret)
                    .param("username", emailAddress)
                    .param("password", password)
                    .param("scope", scopes)
                    .param("grant_type", "password")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<AccessToken> issueAccessToken(String clientId, String clientSecret, String redirectUri, String code) {
        return proceed(AccessToken.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/oauth/token")
                    .param("client_id", clientId)
                    .param("client_secret", clientSecret)
                    .param("redirect_uri", redirectUri)
                    .param("code", code)
                    .param("grant_type", "authorization_code")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response<AccessToken> refreshAccessToken(String clientId, String clientSecret, String refreshToken) {
        return proceed(AccessToken.class, () -> {

            return new HttpRequestBuilder()
                    .target(this.uri)
                    .path("/oauth/token")
                    .param("client_id", clientId)
                    .param("client_secret", clientSecret)
                    .param("refresh_token", refreshToken)
                    .param("grant_type", "refresh_token")
                    .request(HttpMediaType.APPLICATION_JSON)
                    .post();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthorizationUrl(String clientId, String redirectUri, String scopes){

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("client_id", clientId));
        params.add(new HttpParameter("response_type", "code"));
        params.add(new HttpParameter("redirect_uri", redirectUri));
        params.add(new HttpParameter("scope", scopes));

        return this.uri + "/oauth/authorize?" + HttpParameter.encodeParameters(params.toArray(new HttpParameter[0]));
    }
}
