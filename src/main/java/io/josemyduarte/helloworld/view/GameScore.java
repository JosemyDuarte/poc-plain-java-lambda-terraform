package io.josemyduarte.helloworld.view;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBTable(tableName = "GameScores")
public class GameScore {
    @DynamoDBHashKey(attributeName = "userId")
    private String userId;
    @DynamoDBAttribute(attributeName = "gameTitle")
    private String gameTitle;
    @DynamoDBAttribute(attributeName = "topScore")
    private Integer topScore;
}
