package com.arcrobotics.meepmeeptest;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
public class meepmeep4 {
    public static void main(String [] args){
        MeepMeep meepMeep = new MeepMeep(800);
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(0, -40, Math.toRadians(90)))
                                .splineTo(new Vector2d(5,-5),Math.toRadians(0))
                                .splineTo(new Vector2d(20,-15),Math.toRadians(0))
                                .splineTo(new Vector2d(40,10),Math.toRadians(180))
                                .splineTo(new Vector2d(-50,15),Math.toRadians(180))
                                .splineTo(new Vector2d(-40,40),Math.toRadians(0))
                                .splineTo(new Vector2d(50,40),Math.toRadians(0))
                                .build()
                );
        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
