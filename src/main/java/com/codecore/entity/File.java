package com.codecore.entity;

import java.lang.reflect.Array;

public class File {
    private String server_filename;
    private int category;
    private long fs_id;
    private String path;
    private long size;
    private long server_mtime;
    private long server_ctime;
    private long local_mtime;
    private long local_ctime;
    private int isdir;
    private String md5;
    private int dir_empty;
    private Array thumbs;

    public File(String server_filename, int category, long fs_id, String path, long size, long server_mtime, long server_ctime, long local_mtime, long local_ctime, int isdir, String md5, int dir_empty, Array thumbs) {
        this.server_filename = server_filename;
        this.category = category;
        this.fs_id = fs_id;
        this.path = path;
        this.size = size;
        this.server_mtime = server_mtime;
        this.server_ctime = server_ctime;
        this.local_mtime = local_mtime;
        this.local_ctime = local_ctime;
        this.isdir = isdir;
        this.md5 = md5;
        this.dir_empty = dir_empty;
        this.thumbs = thumbs;
    }

    public String getServer_filename() {
        return server_filename;
    }

    public void setServer_filename(String server_filename) {
        this.server_filename = server_filename;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public long getFs_id() {
        return fs_id;
    }

    public void setFs_id(long fs_id) {
        this.fs_id = fs_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getServer_mtime() {
        return server_mtime;
    }

    public void setServer_mtime(long server_mtime) {
        this.server_mtime = server_mtime;
    }

    public long getServer_ctime() {
        return server_ctime;
    }

    public void setServer_ctime(long server_ctime) {
        this.server_ctime = server_ctime;
    }

    public long getLocal_mtime() {
        return local_mtime;
    }

    public void setLocal_mtime(long local_mtime) {
        this.local_mtime = local_mtime;
    }

    public long getLocal_ctime() {
        return local_ctime;
    }

    public void setLocal_ctime(long local_ctime) {
        this.local_ctime = local_ctime;
    }

    public int getIsdir() {
        return isdir;
    }

    public void setIsdir(int isdir) {
        this.isdir = isdir;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getDir_empty() {
        return dir_empty;
    }

    public void setDir_empty(int dir_empty) {
        this.dir_empty = dir_empty;
    }

    public Array getThumbs() {
        return thumbs;
    }

    public void setThumbs(Array thumbs) {
        this.thumbs = thumbs;
    }
}
