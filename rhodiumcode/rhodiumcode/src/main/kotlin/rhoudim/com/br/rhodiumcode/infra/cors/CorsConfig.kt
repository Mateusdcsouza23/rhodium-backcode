package rhoudim.com.br.rhodiumcode.infra.cors

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http:localhost:3001")
            .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE")
    }

}