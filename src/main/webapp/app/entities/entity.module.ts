import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { IppWeekVilleModule } from './ville/ville.module';
import { IppWeekSiteModule } from './site/site.module';
import { IppWeekParcoursModule } from './parcours/parcours.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        IppWeekVilleModule,
        IppWeekSiteModule,
        IppWeekParcoursModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IppWeekEntityModule {}
