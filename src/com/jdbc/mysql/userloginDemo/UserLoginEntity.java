package com.jdbc.mysql.userloginDemo;

/**
 * 用户登录信息实体类
 *
 * @author zhengchao
 * @date 2021-03-12-10:53
 */
public class UserLoginEntity {

    private String account;
    private String password;
    private String createName;
    private String createDatetime;
    private String updateName;
    private String updateDatetime;

    public UserLoginEntity() {}

    public UserLoginEntity(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    /**
     * 1.判断用户名长度
     * 2.判断用户名是否重复
     *
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 需要将加密的密码先解密后再返回
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 1.判断密码是否合规
     * 2.需要先将密码加密后再入库
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginEntity that = (UserLoginEntity) o;
        return account.equals(that.account);
    }

    @Override
    public String toString() {
        return "用户登录信息：" +
                "用户名='" + account + '\'' +
                ", 密码='" + password + '\'' +
                ", 创建人='" + createName + '\'' +
                ", 创建时间='" + createDatetime + '\'' +
                ", 修改人='" + updateName + '\'' +
                ", 修改时间='" + updateDatetime + '\'';
    }
}
