package com.codecore.entity;

public class baiduCapacity {
    private long total; //总空间大小，单位B
    private boolean expire;//7天内是否有容量到期
    private int used; //已使用大小，单位B
    private int free; //剩余大小，单位B

    public baiduCapacity(long total, boolean expire, int used, int free) {
        this.total = total;
        this.expire = expire;
        this.used = used;
        this.free = free;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isExpire() {
        return expire;
    }

    public void setExpire(boolean expire) {
        this.expire = expire;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }
}
