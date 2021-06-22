'use strict';


customElements.define('compodoc-menu', class extends HTMLElement {
    constructor() {
        super();
        this.isNormalMode = this.getAttribute('mode') === 'normal';
    }

    connectedCallback() {
        this.render(this.isNormalMode);
    }

    render(isNormalMode) {
        let tp = lithtml.html(`
        <nav>
            <ul class="list">
                <li class="title">
                    <a href="index.html" data-type="index-link">gamificacao documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="overview.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
                            </a>
                        </li>
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-paper"></span>README
                            </a>
                        </li>
                                <li class="link">
                                    <a href="dependencies.html" data-type="chapter-link">
                                        <span class="icon ion-ios-list"></span>Dependencies
                                    </a>
                                </li>
                    </ul>
                </li>
                    <li class="chapter modules">
                        <a data-type="chapter-link" href="modules.html">
                            <div class="menu-toggler linked" data-toggle="collapse" ${ isNormalMode ?
                                'data-target="#modules-links"' : 'data-target="#xs-modules-links"' }>
                                <span class="icon ion-ios-archive"></span>
                                <span class="link-name">Modules</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                        </a>
                        <ul class="links collapse " ${ isNormalMode ? 'id="modules-links"' : 'id="xs-modules-links"' }>
                            <li class="link">
                                <a href="modules/AppModule.html" data-type="entity-link">AppModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-AppModule-98062f369922589c9391597c2ec34b76"' : 'data-target="#xs-components-links-module-AppModule-98062f369922589c9391597c2ec34b76"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-AppModule-98062f369922589c9391597c2ec34b76"' :
                                            'id="xs-components-links-module-AppModule-98062f369922589c9391597c2ec34b76"' }>
                                            <li class="link">
                                                <a href="components/AlertasComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">AlertasComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/AppComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">AppComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/FeedComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">FeedComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/GruposComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">GruposComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LoginComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LoginComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/MenuComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">MenuComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PerfilComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PerfilComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PerfilEditComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PerfilEditComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PerfilVisitanteComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PerfilVisitanteComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PostQuizComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PostQuizComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/RodapeComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">RodapeComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/TarefasComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">TarefasComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/AppRoutingModule.html" data-type="entity-link">AppRoutingModule</a>
                            </li>
                </ul>
                </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#classes-links"' :
                            'data-target="#xs-classes-links"' }>
                            <span class="icon ion-ios-paper"></span>
                            <span>Classes</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="classes-links"' : 'id="xs-classes-links"' }>
                            <li class="link">
                                <a href="classes/Aprovacao.html" data-type="entity-link">Aprovacao</a>
                            </li>
                            <li class="link">
                                <a href="classes/AprovacaoAmigos.html" data-type="entity-link">AprovacaoAmigos</a>
                            </li>
                            <li class="link">
                                <a href="classes/Atividades.html" data-type="entity-link">Atividades</a>
                            </li>
                            <li class="link">
                                <a href="classes/Grupo.html" data-type="entity-link">Grupo</a>
                            </li>
                            <li class="link">
                                <a href="classes/InscricaoGrupo.html" data-type="entity-link">InscricaoGrupo</a>
                            </li>
                            <li class="link">
                                <a href="classes/Mentalidade.html" data-type="entity-link">Mentalidade</a>
                            </li>
                            <li class="link">
                                <a href="classes/PostagemQuiz.html" data-type="entity-link">PostagemQuiz</a>
                            </li>
                            <li class="link">
                                <a href="classes/Tarefa.html" data-type="entity-link">Tarefa</a>
                            </li>
                            <li class="link">
                                <a href="classes/Usuario.html" data-type="entity-link">Usuario</a>
                            </li>
                            <li class="link">
                                <a href="classes/UsuarioLogin.html" data-type="entity-link">UsuarioLogin</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#injectables-links"' :
                                'data-target="#xs-injectables-links"' }>
                                <span class="icon ion-md-arrow-round-down"></span>
                                <span>Injectables</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                            <ul class="links collapse " ${ isNormalMode ? 'id="injectables-links"' : 'id="xs-injectables-links"' }>
                                <li class="link">
                                    <a href="injectables/AlertasService.html" data-type="entity-link">AlertasService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/AtividadesService.html" data-type="entity-link">AtividadesService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/AuthService.html" data-type="entity-link">AuthService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/FeedServiceService.html" data-type="entity-link">FeedServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/GrupoPostService.html" data-type="entity-link">GrupoPostService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/GrupoService.html" data-type="entity-link">GrupoService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/MenuService.html" data-type="entity-link">MenuService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/MeuPerfilService.html" data-type="entity-link">MeuPerfilService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/TarefasService.html" data-type="entity-link">TarefasService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/UsuarioService.html" data-type="entity-link">UsuarioService</a>
                                </li>
                            </ul>
                        </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#miscellaneous-links"'
                            : 'data-target="#xs-miscellaneous-links"' }>
                            <span class="icon ion-ios-cube"></span>
                            <span>Miscellaneous</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="miscellaneous-links"' : 'id="xs-miscellaneous-links"' }>
                            <li class="link">
                                <a href="miscellaneous/variables.html" data-type="entity-link">Variables</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <a data-type="chapter-link" href="routes.html"><span class="icon ion-ios-git-branch"></span>Routes</a>
                        </li>
                    <li class="chapter">
                        <a data-type="chapter-link" href="coverage.html"><span class="icon ion-ios-stats"></span>Documentation coverage</a>
                    </li>
                    <li class="divider"></li>
                    <li class="copyright">
                        Documentation generated using <a href="https://compodoc.app/" target="_blank">
                            <img data-src="images/compodoc-vectorise.png" class="img-responsive" data-type="compodoc-logo">
                        </a>
                    </li>
            </ul>
        </nav>
        `);
        this.innerHTML = tp.strings;
    }
});