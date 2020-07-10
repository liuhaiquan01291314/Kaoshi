package view;

import com.example.kaoshi.Bean;

import java.util.List;

public interface LonginView {
    void send(List<Bean.DataBean.ListBean> lists);
    void shouToast(String string);
}
