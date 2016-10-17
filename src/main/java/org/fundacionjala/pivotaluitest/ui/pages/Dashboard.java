package org.fundacionjala.pivotaluitest.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectForm;
import org.fundacionjala.pivotaluitest.ui.pages.common.CommonActions;

/**
 * Dashboard page the PivotalTracker.
 */
public class Dashboard extends AbstractBasePage {
    @FindBy(id = "create_new_project_button")
    private WebElement createProjectButton;

    @FindBy(id = "my_projects_list")
    private WebElement projectsList;

    /**
     * This method a clickElement "Create Project" button.
     *
     * @return ProjectForm page.
     */
    public ProjectForm clickCreateProjectButton() {
        CommonActions.clickElement(createProjectButton);
        return new ProjectForm();
    }

    /**
     * This method verify if project exist in the dashboard.
     *
     * @param projectId ProjectId to search.
     * @return Return true if exist the project.
     */
    public Boolean existProject(final String projectId) {
        List<WebElement> projectList = driver.findElements(By.id(String.format("project_%s", projectId)));
        return !projectList.isEmpty();
    }

    /**
     * This method serch a project.
     *
     * @param projectName String Project name.
     * @return StoryDashboard object.
     */
    public StoryDashBoard projectsList(final String projectName) {
        List<WebElement> projects = projectsList.findElements(By.className("project_title"));
        for (WebElement project : projects) {
            if (projectName.equals(project.getText())) {
                CommonActions.clickElement(project);
            }
        }
        return new StoryDashBoard();

    }
}
