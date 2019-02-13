# Test play project to debug rollbar native agent

1. Compile play app

        sbt dist

2. Extract dist to this folder

        rm -rf app
        unzip target/universal/play-native-agent-test-0.0.1.zip -d app

3. Start play app

        env RB=*** ./app/play-native-agent-test-0.0.1/bin/play-native-agent-test -J-agentpath:../rollbar-java/native-agent/target/release/librollbar_java_agent.so

4. Call `/` endpoint to generate an exception

        curl localhost:9000/

