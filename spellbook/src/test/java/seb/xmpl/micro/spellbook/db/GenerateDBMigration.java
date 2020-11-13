package seb.xmpl.micro.spellbook.db;

import io.ebean.dbmigration.DbMigration;

import java.io.IOException;

public class GenerateDBMigration {

    /**
     * Generate the DDL for the next DB migration.
     */
    public static void main(String[] args) throws IOException {

        DbMigration dbMigration = DbMigration.create();
//        dbMigration.setPlatform(Platform.POSTGRES);

        dbMigration.generateMigration();
    }
}
