package com.codecore.entity;

public class baiduAccount {
    private String baidu_name;//百度账号
    private String netdisk_name;//网盘账号
    private String avatar_url;//头像地址
    private int vip_type;//会员类型，0普通用户、1普通会员、2超级会员
    private int uk;//	用户ID

    public baiduAccount(String baidu_name, String netdisk_name, String avatar_url, int vip_type, int uk) {
        this.baidu_name = baidu_name;
        this.netdisk_name = netdisk_name;
        this.avatar_url = avatar_url;
        this.vip_type = vip_type;
        this.uk = uk;
    }

    public String getBaidu_name() {
        return baidu_name;
    }

    public void setBaidu_name(String baidu_name) {
        this.baidu_name = baidu_name;
    }

    public String getNetdisk_name() {
        return netdisk_name;
    }

    public void setNetdisk_name(String netdisk_name) {
        this.netdisk_name = netdisk_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getVip_type() {
        return vip_type;
    }

    public void setVip_type(int vip_type) {
        this.vip_type = vip_type;
    }

    public int getUk() {
        return uk;
    }

    public void setUk(int uk) {
        this.uk = uk;
    }
}
