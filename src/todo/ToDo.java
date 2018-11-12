/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.Scanner;

/**
 *
 * @author jzajac
 */
public class ToDo
{
    static String [] tasks = new String[100];
    static String [] projects = new String[100];
    static String [] changeLog = new String[100];

    static int tasksCount = 0;
    static int projectsCount = 0;
    static int changeLogCount = 0;
    
    
    public static void displayMenu()
    {
        System.out.println("1 - Create new task");
        System.out.println("2 - Remove task");
        System.out.println("3 - Create new project");
        System.out.println("4 - Remove project");
        System.out.println("5 - Display all tasks");
        System.out.println("6 - Display all projects");
        System.out.println("7 - Display all change log");
        System.out.println("0 - Exit app");
    }
    
    public static void addTask (String task)
    {
        boolean hasCapacityForNewTask = tasksCount < tasks.length;
        
        if (hasCapacityForNewTask)
        {
            tasks[tasksCount] = task;
            tasksCount++;
            addChangeLog("Task " + '"' + task + '"' + " was added");
        }
    }
    
    public static void removeTask(int indexTask)
    {
        boolean isTaskExist = indexTask < tasksCount;
        
        if (isTaskExist)
        {
            addChangeLog("Task " + '"' + tasks[indexTask] + '"' + " was removed");
            
            for (int i = indexTask; i < tasksCount - 1; i++)
            {
                tasks[i] = tasks[i + 1];
            }
            
            tasksCount--;
        }
    }
    
    public static void displayTasks()
    {
        System.out.println("List of task: ");
        
        for (int i = 0; i < tasksCount; i++)
        {
            System.out.println(tasks[i]);
        }
    }
    
    public static void addProject (String project)
    {
        boolean hasCapacityForNewProject = projectsCount < projects.length;
        
        if (hasCapacityForNewProject)
        {
            projects[projectsCount] = project;
            projectsCount++;
            addChangeLog("Project " + '"' + project + '"' + " was added");
        }
    }
    
    public static void removeProject(int indexProject)
    {
        boolean isProjectExist = indexProject < projectsCount;
        
        if (isProjectExist)
        {
            addChangeLog("Project " + '"' + projects[indexProject] + '"' + " was removed");
            
            for (int i = indexProject; i < projectsCount - 1; i++)
            {
                projects[i] = projects[i + 1];
            }
            
            projectsCount--;
        }
    }
    
    public static void displayProjects()
    {
        System.out.println("List of projects: ");
        
        for (int i = 0; i < projectsCount; i++)
        {
            System.out.println(projects[i]);
        }
    }
    
    public static void displayChangeLog()
    {
        System.out.println("List of changes: ");
        
        for (int i = 0; i < changeLogCount; i++)
        {
            System.out.println(changeLog[i]);
        }
    }
        
    public static void addChangeLog(String text)
    {
        boolean hasCapacityForChangeLog = changeLogCount < changeLog.length;
        if (hasCapacityForChangeLog)
        {
            changeLog[changeLogCount] = text;
            changeLogCount++;
        }
    }
    
    
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int radix;
        boolean isApplicationRun = true;
        
        while(isApplicationRun)
        {
            displayMenu();
            System.out.println("Type numer to choose option: ");
            radix = scanner.nextInt();
            
            switch(radix)
            {
                case 1:
                    System.out.println("Type new task name: ");
                    String task = scanner.next();
                    addTask(task);
                    break;
                
                case 2:
                    System.out.println("Type task to delete index: ");
                    int task_index = scanner.nextInt();
                    removeTask(task_index);
                    break;
                    
                case 3:
                    System.out.println("Type new project name: ");
                    String project = scanner.next();
                    addProject(project);
                    break;
                
                case 4:
                    System.out.println("Type project to delete index: ");
                    int project_index = scanner.nextInt();
                    removeProject(project_index);
                    break;
                    
                case 5:
                    displayTasks();
                    break;
                 
                case 6:
                    displayProjects();
                    break;
                    
                case 7:
                    displayChangeLog();
                    break;    
                    
                case 0:
                    isApplicationRun = false;
                    break;
                
                default:
                    System.out.println("There is no such option.");
                    break;
                    
            }
        }       
    }  
}
    