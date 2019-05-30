package presenter;

import java.util.List;

import bean.DatasBean;
import model.ModelImpl;
import view.ICallback;
import view.IView;

public class PresenterImpl implements IPresener{
    private final ModelImpl model;
    IView view;

    public PresenterImpl(IView view) {
        this.view = view;
        model = new ModelImpl();
    }

    @Override
    public void updataData() {
        model.updataData(new ICallback() {
            @Override
            public void updataSuccess(List<DatasBean> datasBeans) {
                view.updataSuccess(datasBeans);
            }

            @Override
            public void updaraError(String error) {
                view.updaraError(error);
            }
        });
    }
}
