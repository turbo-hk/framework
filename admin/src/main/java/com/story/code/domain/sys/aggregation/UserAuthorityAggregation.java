package com.story.code.domain.sys.aggregation;

import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.component.tree.TreeHelper;
import com.story.code.domain.sys.converter.MenuConverter;
import com.story.code.domain.sys.entity.UserEntity;
import com.story.code.domain.sys.entity.UserGroupEntity;
import com.story.code.domain.sys.repository.PermissionRepository;
import com.story.code.domain.sys.valueobject.MenuTreeNode;
import com.story.code.domain.sys.valueobject.RoleVO;
import com.story.code.helper.BeanMapperHelper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/28 by Storys.Zhang
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserAuthorityAggregation {

    @Setter
    private UserEntity userEntity;

    @Setter
    private List<UserGroupEntity> userGroupEntityList;

    private List<RoleVO> fullRoleList;
    private List<MenuTreeNode> menuTreeNodeList;

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private MenuConverter menuConverter;

    /**
     * 用户所有的角色包含用户自定义角色+用户所属用户组（及子用户组）的角色列表
     *
     * @return
     */
    public List<RoleVO> getFullRoleList() {
        List<RoleVO> customRoleList = userEntity.getCustomRoleList();
        List<RoleVO> userGroupRoleList = userGroupEntityList.stream().map(UserGroupEntity::getRoleList).flatMap(List::stream).collect(Collectors.toList());
        this.fullRoleList = (List<RoleVO>) CollectionUtils.union(customRoleList, userGroupRoleList);
        return this.fullRoleList;
    }

    /**
     * 用户所有有权限访问的菜单包含用户自定义角色+用户所属用户组（及子用户组）的角色列表对应的菜单权限
     *
     * @return
     */
    public List<MenuTreeNode> getMenuTreeNodeList() {
        List<MenuTreeNode> menuTreeNodeList = permissionRepository.listMenu(getFullRoleList()).parallelStream().map(menuConverter::doToNode).collect(Collectors.toList());
        this.menuTreeNodeList = TreeHelper.build(menuTreeNodeList, DEFAULT_LONG, source -> {
            MenuTreeNode target = new MenuTreeNode();
            BeanMapperHelper.copy(source, target);
            return target;
        });
        return this.menuTreeNodeList;
    }
}
