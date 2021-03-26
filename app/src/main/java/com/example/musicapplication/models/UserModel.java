package com.example.musicapplication.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author choosezzz
 * @date 3/24/21 9:40 PM
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserModel extends RealmObject {

    /**
     * 手机号
     */
    @PrimaryKey
    private String phone;
    /**
     * 密码
     */
    @Required
    private String password;
}
