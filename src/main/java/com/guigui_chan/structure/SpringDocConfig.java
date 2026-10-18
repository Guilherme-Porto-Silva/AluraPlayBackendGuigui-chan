package com.guigui_chan.structure;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class SpringDocConfig {

    private final String DESCICAO_API = "API Rest da aplicação AluraPlay, contendo as funcionalidades de C.R.U.D.";

    private final String EMAIL = "aluraPlayBackend@gmail.com";

    private final String NOME_API = "Time Backend";

    private final String ENDERECO_LICENCA = "http://aluraPlay/api/licence";

    private final String NOME_LICENCA = "Apache 2.0";

    private final String TITULO_API = "AluraPlay API";

    @Bean public OpenAPI customOpenAPI () {

        OpenAPI retorno = new OpenAPI();

        Components componente = new Components();

        SecurityScheme scheme = new SecurityScheme();

        Info informations = new Info();

        Contact contact = new Contact();

        License licence = new License();

        licence.name(NOME_LICENCA).url(ENDERECO_LICENCA);

        contact.name(NOME_API).email(EMAIL);

        informations.title(TITULO_API).description(DESCICAO_API).contact(contact).license(licence);

        scheme.type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");

        componente.addSecuritySchemes("bearer-key", scheme);//@SecurityRequirement(name = "bearer-key")

        retorno.info(informations).components(componente);

        return retorno;
    }
}