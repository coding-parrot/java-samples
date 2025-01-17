// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.classroom.model.Topic;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TestDeleteTopic extends BaseTest {
  @Test
  public void testDeleteTopic() throws IOException {
    Topic topic = CreateTopic.createTopic(testCourse.getId());
    DeleteTopic.deleteTopic(testCourse.getId(), topic.getTopicId());
    Assert.assertThrows(GoogleJsonResponseException.class,
        () -> GetTopic.getTopic(testCourse.getId(), topic.getTopicId()));
  }
}
