const init = require('./init.js');

const enSideBar = init.makeSideBar('en');
const zhSideBar = init.makeSideBar('zh');

module.exports = {
    base: "/",
    description: 'Here are some thoughts about lintcode\' problems',
    nav: [
        {text: 'Github', link: 'https://github.com/Haixiang6123/Lintcode'},
    ],
    locales: {
        '/': {
            title: 'Notes',
            lang: 'en-US'
        },
        '/zh/': {
            title: '笔记',
            lang: 'zh-CN'
        }
    },
    themeConfig: {
        locales: {
            '/': {
                selectText: 'Languages',
                label: 'English',
                nav: [
                    {text: 'Github', link: 'https://github.com/Haixiang6123/Lintcode'}
                ],
                sidebar: {
                    '/': enSideBar
                }
            },
            '/zh/': {
                title: '笔记',
                selectText: '选择语言',
                label: '简体中文',
                nav: [
                    {text: 'Github', link: 'https://github.com/Haixiang6123/Lintcode'}
                ],
                sidebar: {
                    '/zh/': zhSideBar
                }
            }
        }
    }
};