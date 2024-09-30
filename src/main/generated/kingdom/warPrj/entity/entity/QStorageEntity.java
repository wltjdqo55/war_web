package kingdom.warPrj.entity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStorageEntity is a Querydsl query type for StorageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStorageEntity extends EntityPathBase<StorageEntity> {

    private static final long serialVersionUID = 1496373427L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStorageEntity storageEntity = new QStorageEntity("storageEntity");

    public final NumberPath<Integer> attackBonus = createNumber("attackBonus", Integer.class);

    public final NumberPath<Integer> defenseBonus = createNumber("defenseBonus", Integer.class);

    public final NumberPath<Integer> forceBonus = createNumber("forceBonus", Integer.class);

    public final StringPath item = createString("item");

    public final StringPath itemName = createString("itemName");

    public final BooleanPath itemState = createBoolean("itemState");

    public final QSoldierEntity soldierEntity;

    public final NumberPath<Integer> spellBonus = createNumber("spellBonus", Integer.class);

    public final NumberPath<Long> storageId = createNumber("storageId", Long.class);

    public QStorageEntity(String variable) {
        this(StorageEntity.class, forVariable(variable), INITS);
    }

    public QStorageEntity(Path<? extends StorageEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStorageEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStorageEntity(PathMetadata metadata, PathInits inits) {
        this(StorageEntity.class, metadata, inits);
    }

    public QStorageEntity(Class<? extends StorageEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.soldierEntity = inits.isInitialized("soldierEntity") ? new QSoldierEntity(forProperty("soldierEntity"), inits.get("soldierEntity")) : null;
    }

}

