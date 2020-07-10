package p;

import com.example.kaoshi.BaseApp;
import com.example.kaoshi.Bean;

import java.util.List;

import moled.LonginM;
import view.LonginView;

public class Longinp implements BaseApp {
    private LonginView longinView;
    private LonginM longinM;

    public Longinp(LonginView longinView) {
        this.longinView = longinView;
        this.longinM=new LonginM();
    }

    @Override
    public void onlist(List<Bean.DataBean.ListBean> beanList) {
         longinView.send(beanList);
    }

    @Override
    public void onfine(String string) {
         longinView.shouToast(string);
    }

    public void setdata() {
        longinM.getdata(this);
    }
}
