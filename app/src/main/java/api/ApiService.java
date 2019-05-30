package api;

import bean.DatasBean;
import bean.DemoBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    public String url = "https://www.wanandroid.com/";
    @GET("article/list/0/json")
    Observable<DemoBean> getData();
}
