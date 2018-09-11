const fs = require('fs');

const enNotesFolder = process.cwd() + '/docs/en/';
const zhNotesFolder = process.cwd() + '/docs/zh/';

const Dict = require('./dict.js');

function readCategories(basePath, sideBar, dict) {
    var categories = fs.readdirSync(basePath);
    var categoryPath;

    categories.forEach(function (category) {
        categoryPath = basePath + category;
        if (!fs.statSync(categoryPath).isFile()) {
            var sideBarItem = {title: dict[category], children: []};

            readNotes(categoryPath, sideBarItem, category);

            sideBar.push(sideBarItem);
        }
    });
}

function readNotes(categoryPath, sideBarItem, category) {
    var notes = fs.readdirSync(categoryPath);

    notes.forEach(function (note) {
        if (note.startsWith('.')) {
            return;
        }
        sideBarItem.children.push('/' + category + "/" + note);
    });
}

function addLangPrefix(lang, sideBarObj) {
    sideBarObj.forEach(function (sideBarItem) {
        sideBarItem.children = sideBarItem.children.map(function (noteDir) {
            return '/' + lang + noteDir;
        });
    });
}

module.exports = {
    makeSideBar: function (lang) {
        const basePath = (lang === 'en') ? enNotesFolder : zhNotesFolder;
        const dict = (lang === 'en') ? Dict.enDict : Dict.zhDict;
        var sideBar = [];

        readCategories(basePath, sideBar, dict);

        addLangPrefix(lang, sideBar);

        return sideBar;
    }
};