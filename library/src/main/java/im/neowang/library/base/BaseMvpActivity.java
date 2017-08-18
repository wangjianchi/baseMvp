package im.neowang.library.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by cd14 on 2017/6/27.
 */

public abstract class BaseMvpActivity<T extends IBasePresenter> extends RxAppCompatActivity implements IBaseView {
    protected T mPresenter;

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    @LayoutRes
    protected abstract int attachLayoutRes();

    /**
     * 初始化视图控件
     */
    protected abstract void initViews();

    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        setContentView(attachLayoutRes());
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }


    /**
     * 右侧点击问题
     */
    protected void onToolbarRightClick() {
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 显示列表的等待动画
     *
     * @param str
     */
    protected Dialog progressDialog;


    /**
     * 移除列表的等待动画
     */
    protected void hideProgress() {
        if (progressDialog != null) {
            progressDialog.hide();
        }
    }

}
