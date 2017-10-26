import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Parcours } from './parcours.model';
import { ParcoursPopupService } from './parcours-popup.service';
import { ParcoursService } from './parcours.service';
import { Ville, VilleService } from '../ville';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-parcours-dialog',
    templateUrl: './parcours-dialog.component.html'
})
export class ParcoursDialogComponent implements OnInit {

    parcours: Parcours;
    isSaving: boolean;

    villes: Ville[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private parcoursService: ParcoursService,
        private villeService: VilleService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.villeService.query()
            .subscribe((res: ResponseWrapper) => { this.villes = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.parcours.id !== undefined) {
            this.subscribeToSaveResponse(
                this.parcoursService.update(this.parcours));
        } else {
            this.subscribeToSaveResponse(
                this.parcoursService.create(this.parcours));
        }
    }

    private subscribeToSaveResponse(result: Observable<Parcours>) {
        result.subscribe((res: Parcours) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError());
    }

    private onSaveSuccess(result: Parcours) {
        this.eventManager.broadcast({ name: 'parcoursListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackVilleById(index: number, item: Ville) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-parcours-popup',
    template: ''
})
export class ParcoursPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private parcoursPopupService: ParcoursPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.parcoursPopupService
                    .open(ParcoursDialogComponent as Component, params['id']);
            } else {
                this.parcoursPopupService
                    .open(ParcoursDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
