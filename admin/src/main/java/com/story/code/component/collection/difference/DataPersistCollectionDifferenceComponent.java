package com.story.code.component.collection.difference;

import java.util.Collection;
import java.util.List;

/**
 * 数据持久化操作
 * <p>
 * source -> 请求数据 target -> 数据库查询出来的数据
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
public class DataPersistCollectionDifferenceComponent<T> extends AbstractCollectionDifferenceComponent<T> {

    public DataPersistCollectionDifferenceComponent(Collection source, Collection target) {
        super(source, target);
    }

    /**
     * 需要新增的数据
     */
    private CollectionDifferenceFunction addFunction;

    /**
     * 需要修改的数据
     */
    private CollectionDifferenceFunction updateFunction;

    /**
     * 需要删除的数据
     */
    private CollectionDifferenceFunction deleteFunction;

    public DataPersistCollectionDifferenceComponent<T> build(){
        return this.buildAdd().buildDelete().buildUpdate();
    }

    /**
     * 需要新增的数据， source存在，target不存在
     *
     * @return
     */
    public DataPersistCollectionDifferenceComponent<T> buildAdd() {
        this.addFunction = SourceTargetDifferenceFunction::difference;
        return this;
    }

    /**
     * 需要修改的数据，source，target的交集
     *
     * @return
     */
    public DataPersistCollectionDifferenceComponent<T> buildUpdate() {
        this.updateFunction = IntersectionFunction::difference;
        return this;
    }

    /**
     * 需要删除的数据， source没有，target有
     *
     * @return
     */
    public DataPersistCollectionDifferenceComponent<T> buildDelete() {
        this.deleteFunction = TargetSourceDifferenceFunction::difference;
        return this;
    }

    public List<T> add() {
        return this.addFunction.apply(this);
    }

    public List<T> update() {
        return this.updateFunction.apply(this);
    }

    public List<T> delete() {
        return this.deleteFunction.apply(this);
    }

}
