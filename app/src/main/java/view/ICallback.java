package view;

import java.util.List;

import bean.DatasBean;

public interface ICallback {
    void updataSuccess(List<DatasBean> datasBeans);
    void updaraError(String error);
}
