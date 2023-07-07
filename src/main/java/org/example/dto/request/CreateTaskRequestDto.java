package org.example.dto.request;

public class CreateTaskRequestDto {

    private String name;
    private String description;
    private String status;
    private String priority;
    private String assignees;
    private String timeEstimate;
    private String parent;
    private boolean archived;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(final String priority) {
        this.priority = priority;
    }

    public String getAssignees() {
        return assignees;
    }

    public void setAssignees(final String assignees) {
        this.assignees = assignees;
    }

    public String getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(final String timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(final String parent) {
        this.parent = parent;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(final boolean archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        return "CreateTaskRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", assignees='" + assignees + '\'' +
                ", timeEstimate='" + timeEstimate + '\'' +
                ", parent='" + parent + '\'' +
                ", archived=" + archived +
                '}';
    }
}
