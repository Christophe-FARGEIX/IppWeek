import { BaseEntity } from './../../shared';

export class Site implements BaseEntity {
    constructor(
        public id?: number,
        public siteId?: number,
        public nom?: string,
        public lienUrl?: string,
        public prix?: number,
        public description?: string,
        public adresse?: string,
        public villes?: BaseEntity[],
        public parcours?: BaseEntity,
    ) {
    }
}
