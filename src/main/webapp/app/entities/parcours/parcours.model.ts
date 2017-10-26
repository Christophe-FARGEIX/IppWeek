import { BaseEntity } from './../../shared';

export class Parcours implements BaseEntity {
    constructor(
        public id?: number,
        public titre?: string,
        public villeId?: string,
        public siteId?: string,
        public ville?: BaseEntity,
        public sites?: BaseEntity[],
    ) {
    }
}
