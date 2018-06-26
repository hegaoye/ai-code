/*
 * ${copyright}
 */
package ${basePackage}.${model}.service;

import java.util.List;
import java.util.Date;

import ${basePackage}.${model}.entity.${className};

/**
 * ${notes}
 *
 * @author ${author}
 */
public interface ${className}SV {

<#if (pkFields?size>0)>

    /**
     * 加载一个对象${className}
     * <#list pkFields as pkField>@param ${pkField.field} ${pkField.notes}</#list>
     * @return ${className}
     */
     ${className} load(<#list pkFields as pkField>${pkField.fieldType} ${pkField.field}<#if pkField_has_next>,</#if></#list>);

    <#list pkFields as pkField>
    /**
     * 加载一个对象${className} 通过${pkField.field}
     * @param ${pkField.field} ${pkField.notes}
     * @return ${className}
     */
     ${className} loadBy${pkField.field?cap_first}(${pkField.fieldType} ${pkField.field});
   </#list>

    /**
     * 删除对象${className}
     * <#list pkFields as pkField>@param ${pkField.field} ${pkField.notes}</#list>
     * @return ${className}
     */
     void delete(<#list pkFields as pkField>${pkField.fieldType} ${pkField.field}<#if pkField_has_next>,</#if></#list>);
</#if>



    /**
     * 查询${className}分页
     *
     * @param ${classNameLower}  ${notes}
     * @param offset 查询开始行
     * @param limit  查询行数
     * @return List<${className}>
     */
     List<${className}> list(${className} ${classNameLower}, int offset, int limit);
     int count(${className} ${classNameLower});

     /**
     * 查询${className}分页
     *
     <#list pkFields as pkField>* @param ${pkField.field}  ${pkField.notes}</#list>
     * @param offset 查询开始行
     * @param limit  查询行数
     * @return List<${className}>
     */
     List<${className}> list(<#list pkFields as pkField>${pkField.fieldType} ${pkField.field},</#list>int offset, int limit);
     int count(<#list pkFields as pkField>${pkField.fieldType} ${pkField.field}<#if pkField_has_next>,</#if></#list>);


    /**
    * 保存 ${className}
    *
    * @param ${classNameLower} 对象
    */
    void save(${className} ${classNameLower});



    /**
    * 更新 ${className}
    *
    * @param ${classNameLower} 对象
    */
    void modify(${className} ${classNameLower});

}
