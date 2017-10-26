import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Parcours } from './parcours.model';
import { ParcoursPopupService } from './parcours-popup.service';
import { ParcoursService } from './parcours.service';

@Component({
    selector: 'jhi-parcours-delete-dialog',
    templateUrl: './parcours-delete-dialog.component.html'
})
export class ParcoursDeleteDialogComponent {

    parcours: Parcours;

    constructor(
        private parcoursService: ParcoursService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.parcoursService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'parcoursListModification',
                content: 'Deleted an parcours'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-parcours-delete-popup',
    template: ''
})
export class ParcoursDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private parcoursPopupService: ParcoursPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.parcoursPopupService
                .open(ParcoursDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
