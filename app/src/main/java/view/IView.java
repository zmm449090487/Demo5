package view;

import java.util.List;

import bean.DatasBean;

public interface IView {
    void updataSuccess(List<DatasBean> datasBeans);
    void updaraError(String error);
}
