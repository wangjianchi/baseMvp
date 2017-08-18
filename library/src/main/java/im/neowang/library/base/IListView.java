package im.neowang.library.base;

/**
 * Created by cd14 on 2017/6/28.
 * 列表基础view
 */

public interface IListView extends IBaseView{


    /**
     * 全部数据加载完成
     */
    void loadAllComplete();
    /**
     * 没有数据
     */
    void noData();
}
