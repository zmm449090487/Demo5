package model;

import android.util.Log;

import com.example.lenovo.demo1.DataService;

import java.util.List;

import api.ApiService;
import bean.DatasBean;
import bean.DemoBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import view.ICallback;

public class ModelImpl implements IModel{
    private static final String TAG = "ModelImpl";
    @Override
    public void updataData(final ICallback callback) {//张苗苗
        ApiService apiService = DataService.getApiService();
        apiService.getData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DemoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(DemoBean demoBean) {
                        List<DatasBean> datas = demoBean.getData().getDatas();
                        Log.d(TAG, "onNext: "+datas);
                        callback.updataSuccess(datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
