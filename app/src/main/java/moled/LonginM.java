package moled;

import com.example.kaoshi.Apiservice;
import com.example.kaoshi.BaseApp;
import com.example.kaoshi.Bean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import p.Longinp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LonginM {

    public void getdata(final BaseApp baseApp) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Apiservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Apiservice apiservice = build.create(Apiservice.class);
        Observable<Bean> data = apiservice.data();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                       baseApp.onlist(bean.getData().getList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseApp.onfine(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
