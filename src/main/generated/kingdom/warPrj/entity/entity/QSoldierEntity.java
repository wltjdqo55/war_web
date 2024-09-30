package kingdom.warPrj.entity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSoldierEntity is a Querydsl query type for SoldierEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSoldierEntity extends EntityPathBase<SoldierEntity> {

    private static final long serialVersionUID = -1709672838L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSoldierEntity soldierEntity = new QSoldierEntity("soldierEntity");

    public final NumberPath<Integer> attack = createNumber("attack", Integer.class);

    public final NumberPath<Integer> defense = createNumber("defense", Integer.class);

    public final NumberPath<Integer> force = createNumber("force", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> intelligence = createNumber("intelligence", Integer.class);

    public final ListPath<StorageEntity, QStorageEntity> items = this.<StorageEntity, QStorageEntity>createList("items", StorageEntity.class, QStorageEntity.class, PathInits.DIRECT2);

    public final QSkillEntity skill;

    public final NumberPath<Integer> soldierAge = createNumber("soldierAge", Integer.class);

    public final StringPath soldierBirthPlace = createString("soldierBirthPlace");

    public final StringPath soldierId = createString("soldierId");

    public final StringPath soldierName = createString("soldierName");

    public final StringPath soldierPassword = createString("soldierPassword");

    public final BooleanPath soldierState = createBoolean("soldierState");

    public final QSpeciesEntity species;

    public final NumberPath<Integer> spell = createNumber("spell", Integer.class);

    public final NumberPath<Integer> strength = createNumber("strength", Integer.class);

    public QSoldierEntity(String variable) {
        this(SoldierEntity.class, forVariable(variable), INITS);
    }

    public QSoldierEntity(Path<? extends SoldierEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSoldierEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSoldierEntity(PathMetadata metadata, PathInits inits) {
        this(SoldierEntity.class, metadata, inits);
    }

    public QSoldierEntity(Class<? extends SoldierEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.skill = inits.isInitialized("skill") ? new QSkillEntity(forProperty("skill")) : null;
        this.species = inits.isInitialized("species") ? new QSpeciesEntity(forProperty("species")) : null;
    }

}

