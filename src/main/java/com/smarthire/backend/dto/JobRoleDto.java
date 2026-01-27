package com.smarthire.backend.dto;
import jakarta.validation.constraints.NotBlank;
public class JobRoleDto {
    private Long id;
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Description cannot be empty")
    private String description;
    public JobRoleDto() {}
    public JobRoleDto(Long id,String title,String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}
