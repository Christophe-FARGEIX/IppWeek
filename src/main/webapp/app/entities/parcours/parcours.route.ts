import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { ParcoursComponent } from './parcours.component';
import { ParcoursDetailComponent } from './parcours-detail.component';
import { ParcoursPopupComponent } from './parcours-dialog.component';
import { ParcoursDeletePopupComponent } from './parcours-delete-dialog.component';

export const parcoursRoute: Routes = [
    {
        path: 'parcours',
        component: ParcoursComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Parcours'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'parcours/:id',
        component: ParcoursDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Parcours'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const parcoursPopupRoute: Routes = [
    {
        path: 'parcours-new',
        component: ParcoursPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Parcours'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'parcours/:id/edit',
        component: ParcoursPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Parcours'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'parcours/:id/delete',
        component: ParcoursDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Parcours'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
