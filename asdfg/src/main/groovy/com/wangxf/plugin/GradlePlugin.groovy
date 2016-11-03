package com.wangxf.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class GradlePlugin implements Plugin<Project> {

    void apply(Project project) {
        project.task('myTask') << {
            println "Hi this is micky's plugin"
        }

    }
}