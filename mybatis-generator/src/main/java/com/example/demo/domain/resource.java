package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class resource implements Serializable {
    private Long id;

    private Long platformId;

    private String type;

    private String name;

    private Long pid;

    private Byte systemDefault;

    private String url;

    private Byte level;

    private String owner;

    private Integer orderNum;

    private Date created;

    private Date updated;

    private Byte yn;

    private String code;

    private String icon;

    private String target;

    private String htmlCode;

    private static final long serialVersionUID = 1L;

    public resource(Long id, Long platformId, String type, String name, Long pid, Byte systemDefault, String url, Byte level, String owner, Integer orderNum, Date created, Date updated, Byte yn, String code, String icon, String target, String htmlCode) {
        this.id = id;
        this.platformId = platformId;
        this.type = type;
        this.name = name;
        this.pid = pid;
        this.systemDefault = systemDefault;
        this.url = url;
        this.level = level;
        this.owner = owner;
        this.orderNum = orderNum;
        this.created = created;
        this.updated = updated;
        this.yn = yn;
        this.code = code;
        this.icon = icon;
        this.target = target;
        this.htmlCode = htmlCode;
    }

    public Long getId() {
        return id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Long getPid() {
        return pid;
    }

    public Byte getSystemDefault() {
        return systemDefault;
    }

    public String getUrl() {
        return url;
    }

    public Byte getLevel() {
        return level;
    }

    public String getOwner() {
        return owner;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Byte getYn() {
        return yn;
    }

    public String getCode() {
        return code;
    }

    public String getIcon() {
        return icon;
    }

    public String getTarget() {
        return target;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformId=").append(platformId);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", pid=").append(pid);
        sb.append(", systemDefault=").append(systemDefault);
        sb.append(", url=").append(url);
        sb.append(", level=").append(level);
        sb.append(", owner=").append(owner);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", yn=").append(yn);
        sb.append(", code=").append(code);
        sb.append(", icon=").append(icon);
        sb.append(", target=").append(target);
        sb.append(", htmlCode=").append(htmlCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}