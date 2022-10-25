package com.kpoma.film

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@SpringBootApplication
@EnableSwagger2
class FilmApplication{
    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            "Gestion film",
            "Cette permet de gerer les films et playlist utilisateurs.",
            "1.0",
            "Termes et Conditions",
            Contact("Technolyne", "www.technolyne.com", "contact@technolyne.com"),
            "License of API",
            "www.technolyne.com",
            Collections.emptyList()
        )
    }

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            //.apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.kpoma.film.controller"))
            .paths(PathSelectors.any())
            .build()
    }
}

fun main(args: Array<String>) {
    runApplication<FilmApplication>(*args)
}
