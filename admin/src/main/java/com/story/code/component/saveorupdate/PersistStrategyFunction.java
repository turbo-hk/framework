package com.story.code.component.saveorupdate;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@FunctionalInterface
public interface PersistStrategyFunction {

    /**
     * 持久化
     *
     * @return
     */
    int persist();
}
