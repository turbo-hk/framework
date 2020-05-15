package com.story.code.domain.dict.valueobject;

import com.story.code.boot.SpringContextHolder;
import com.story.code.domain.dict.repository.DictRepository;
import java.util.Optional;
import lombok.Getter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
public enum DictNodeCodeEnum {

    DEL_FLAG("DEL_FLAG", "删除标识") {
        @Override
        public Ops ops() {
            return new Ops(this.getCode());
        }
    },
    DISABLED("DISABLED", "禁用标识") {
        @Override
        public Ops ops() {
            return new Ops(this.getCode());
        }
    },
    ;

    @Getter
    private final String code;

    @Getter
    private final String title;

    public abstract Ops ops();

    DictNodeCodeEnum(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public class Ops {

        private String dictNodeCode;

        public Ops(String dictNodeCode) {
            this.dictNodeCode = dictNodeCode;
        }

        public Optional<DictNodeVO> getDict() {
            return SpringContextHolder.getBean(DictRepository.class).getDict(this.dictNodeCode);
        }

        public Optional<DictValueVO> getDictValue(String dictValueCode) {
            return SpringContextHolder.getBean(DictRepository.class).getDictValue(this.dictNodeCode, dictValueCode);
        }
    }
}
