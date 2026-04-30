package org.kevin.models;

import java.util.List;

public class UserResponse {
    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private List<User> data;
    private Support support;

    // Getters and Setters
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public int getPerPage() { return perPage; }
    public void setPerPage(int perPage) { this.perPage = perPage; }
    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }
    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
    public List<User> getData() { return data; }
    public void setData(List<User> data) { this.data = data; }
    public Support getSupport() { return support; }
    public void setSupport(Support support) { this.support = support; }

}

class Support{
    private String url;
    private String text;

    // Getters and Setters
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}