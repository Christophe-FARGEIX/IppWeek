import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IppWeekSharedModule } from '../../shared';
import {
    ParcoursService,
    ParcoursPopupService,
    ParcoursComponent,
    ParcoursDetailComponent,
    ParcoursDialogComponent,
    ParcoursPopupComponent,
    ParcoursDeletePopupComponent,
    ParcoursDeleteDialogComponent,
    parcoursRoute,
    parcoursPopupRoute,
} from './';

const ENTITY_STATES = [
    ...parcoursRoute,
    ...parcoursPopupRoute,
];

@NgModule({
    imports: [
        IppWeekSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ParcoursComponent,
        ParcoursDetailComponent,
        ParcoursDialogComponent,
        ParcoursDeleteDialogComponent,
        ParcoursPopupComponent,
        ParcoursDeletePopupComponent,
    ],
    entryComponents: [
        ParcoursComponent,
        ParcoursDialogComponent,
        ParcoursPopupComponent,
        ParcoursDeleteDialogComponent,
        ParcoursDeletePopupComponent,
    ],
    providers: [
        ParcoursService,
        ParcoursPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IppWeekParcoursModule {}
