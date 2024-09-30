package kingdom.warPrj.entity.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSkillEntity is a Querydsl query type for SkillEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSkillEntity extends EntityPathBase<SkillEntity> {

    private static final long serialVersionUID = -426327735L;

    public static final QSkillEntity skillEntity = new QSkillEntity("skillEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath skillName = createString("skillName");

    public final BooleanPath skillState = createBoolean("skillState");

    public final NumberPath<Integer> spellBonus = createNumber("spellBonus", Integer.class);

    public final NumberPath<Integer> strengthBonus = createNumber("strengthBonus", Integer.class);

    public QSkillEntity(String variable) {
        super(SkillEntity.class, forVariable(variable));
    }

    public QSkillEntity(Path<? extends SkillEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSkillEntity(PathMetadata metadata) {
        super(SkillEntity.class, metadata);
    }

}

